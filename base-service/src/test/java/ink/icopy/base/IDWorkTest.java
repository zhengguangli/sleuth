package ink.icopy.base;

public class IDWorkTest {
	private long workerId;
	private long dataCenterId;
	private long sequence;
	private long twepoch = 1288834974657L;

	private long workerIdBits = 5L;
	private long dataCenterIdBits = 5L;

	// 这个是二进制运算，就是 5 bit最多只能有31个数字，也就是说机器id最多只能是32以内
	private long maxWorkerId = -1L ^ (-1L << workerIdBits);

	// 这个是一个意思，就是 5 bit最多只能有31个数字，机房id最多只能是32以内
	private long maxDataCenterId = -1L ^ (-1L << dataCenterIdBits);
	private long sequenceBits = 12L;

	private long workerIdShift = sequenceBits;
	private long dataCenterIdShift = sequenceBits + workerIdBits;
	private long timestampLeftShift = sequenceBits + workerIdBits + dataCenterIdBits;
	private long sequenceMask = -1L ^ (-1L << sequenceBits);

	private long lastTimestamp = -1L;

	public IDWorkTest(long workerId, long dataCenterId, long sequence) {
		if (workerId > dataCenterId || workerId < 0) {
			throw new IllegalArgumentException(String.format("work Id can't be greater than %d or less than 0", maxWorkerId));
		}
		if (dataCenterId > maxDataCenterId || dataCenterId < 0) {
			throw new IllegalArgumentException(String.format("dataCenter Id can't be greater than %d or less than 0", maxDataCenterId));
		}
		System.out.printf(
						"worker starting. timestamp left shift %d, datacenter id bits %d, worker id bits %d, sequence bits %d, workerid %d",
						timestampLeftShift, dataCenterIdBits, workerIdBits, sequenceBits, workerId);
		this.workerId = workerId;
		this.dataCenterId = dataCenterId;
		this.sequence = sequence;
	}

	public synchronized long nextId() {
		long timestamp = timeGen();
		if (timestamp < lastTimestamp) {
			System.err.printf("clock is moving backwards.  Rejecting requests until %d.", lastTimestamp);
			throw new RuntimeException(String.format(
							"Clock moved backwards.  Refusing to generate id for %d milliseconds", lastTimestamp - timestamp));
		}
		if (timestamp == lastTimestamp) {
			sequence = (sequence + 1) & sequenceMask;
		} else {
			sequence = 0;
		}

		lastTimestamp = timestamp;
		return ((timestamp - twepoch) << timestampLeftShift) | (dataCenterId << dataCenterIdShift) | (workerId << workerIdShift) | sequence;
	}

	private long tilNextMillis(long lastTimestamp) {
		long timestamp = timeGen();
		while (timestamp <= lastTimestamp) {
			timestamp = timeGen();
		}
		return timestamp;
	}

	private long timeGen() {
		return System.currentTimeMillis();
	}


	public long getWorkerId() {
		return workerId;
	}

	public long getDataCenterId() {
		return dataCenterId;
	}

	public long getTimestamp() {
		return System.currentTimeMillis();
	}

	public static void main(String[] args) {
		IDWorkTest idWorkTest = new IDWorkTest(1, 1, 1);
		for (int i = 0; i < 30; i++) {
			System.out.println(idWorkTest.nextId());
		}
	}

}
