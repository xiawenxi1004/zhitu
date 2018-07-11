package com.example.demo.model;

import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
/*
 * 知途教育自定义响应体
 */
public class ZhiTuResultUpdate {
	
	 // 定义jackson对象
    private static final ObjectMapper MAPPER = new ObjectMapper();
	//状态
	private Integer error_code;
	//错误信息
	private String message;
	//数据
	private Object data;
	
	public Integer getError_code() {
		return error_code;
	}
	public void setError_code(Integer error_code) {
		this.error_code = error_code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public ZhiTuResultUpdate() {
		
	}
	public ZhiTuResultUpdate(Integer error_code, String message, Object data) {
		super();
		this.error_code = error_code;
		this.message = message;
		this.data = data;
	}
	public ZhiTuResultUpdate(Object data) {
		this.error_code=0;
		this.message="success";
		this.data=data;
	}
	
	public static ZhiTuResultUpdate ok() {
        return new ZhiTuResultUpdate(null);
    }
	
	public static ZhiTuResultUpdate ok(Object data) {
		return new ZhiTuResultUpdate(data);
    }
	/*
	 * 转化json数据为pojo
	 */
	 public static ZhiTuResultUpdate formatToPojo(String jsonData, Class<?> clazz) {
	        try {
	            if (clazz == null) {
	                return MAPPER.readValue(jsonData, ZhiTuResultUpdate.class);
	            }
	            JsonNode jsonNode = MAPPER.readTree(jsonData);
	            JsonNode data = jsonNode.get("data");
	            Object obj = null;
	            if (clazz != null) {
	                if (data.isObject()) {
	                    obj = MAPPER.readValue(data.traverse(), clazz);
	                } else if (data.isTextual()) {
	                    obj = MAPPER.readValue(data.asText(), clazz);
	                }
	            }
	            return build(jsonNode.get("status").intValue(), jsonNode.get("msg").asText(), obj);
	        } catch (Exception e) {
	            return null;
	        }
	    }
	 /**
	     * Object是集合转化
	     * 
	     * @param jsonData json数据
	     * @param clazz 集合中的类型
	     * @return
	     */
	    public static ZhiTuResultUpdate formatToList(String jsonData, Class<?> clazz) {
	        try {
	            JsonNode jsonNode = MAPPER.readTree(jsonData);
	            JsonNode data = jsonNode.get("data");
	            Object obj = null;
	            if (data.isArray() && data.size() > 0) {
	                obj = MAPPER.readValue(data.traverse(),
	                        MAPPER.getTypeFactory().constructCollectionType(List.class, clazz));
	            }
	            return build(jsonNode.get("error_code").intValue(), jsonNode.get("message").asText(), obj);
	        } catch (Exception e) {
	            return null;
	        }
	    }
	private static ZhiTuResultUpdate build(int error_code, String message, Object data) {
		 return new ZhiTuResultUpdate(error_code, message, data);
		
	}
	  public static ZhiTuResultUpdate build(Integer error_code, String message) {
	        return new ZhiTuResultUpdate(error_code, message, null);
	    }
	  

}
