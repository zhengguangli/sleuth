package wang.icopy.jwt;

import org.json.JSONObject;

/** @author lizhengguang */
public class JSONResult {
  public static String fillResultString(Integer status, String message, Object result) {
    JSONObject jsonObject =
        new JSONObject() {
          {
            put("status", status);
            put("message", message);
            put("result", result);
          }
        };
    return jsonObject.toString();
  }
}
