package com.wx.controller;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.common.utils.EncryptUtil;

@Controller
public class WXController {

	private Logger log = Logger.getLogger(WXController.class);
	
	//@RequestMapping(value="validate.do")
	public String validate(HttpServletRequest request, HttpServletResponse response){
		/**
		 * 验证URL有效性
		 */
		String signature = request.getParameter("signature");
		String timestamp = request.getParameter("timestamp");
		String nonce = request.getParameter("nonce");
		String echostr = request.getParameter("echostr");
		log.info("signature----------->" + signature);
		log.info("timestamp----------->" + timestamp);
		log.info("nonce----------->" + nonce);
		log.info("echostr----------->" + echostr);
		
		if(StringUtils.isBlank(signature) || StringUtils.isBlank(timestamp) 
				|| StringUtils.isBlank(nonce) || StringUtils.isBlank(echostr)){
			log.info("参数存在空值");
			return null;
		}
		
		try {
			String[] params = {"weixin", timestamp, nonce};
			Arrays.sort(params);
			log.info("字典排序后的数组：" + Arrays.toString(params));
			
			String str = params[0] + params[1] + params[2];
			
			String newSignature = EncryptUtil.SHA1(str);
			log.info("3个参数进行加密后，得到的新字符串是：" + newSignature);
			
			if(signature.equals(newSignature)){
				log.info("两个字符串进行对比：OK");
				response.getWriter().print(echostr);
			}
			
		} catch (Exception e) {
			log.error("validate方法报错，错误信息为：" + e.getMessage());
			e.printStackTrace();
		}
		
		return null;
	}
	
	@RequestMapping(value="validate.do")
	public String receiveMessage(HttpServletRequest request, HttpServletResponse response){
		/**
		 * 接收消息
		 */
		boolean truth = validateTruth(request, response);
		log.info("0--------truth----------->" + truth);
		
		String param = request.getParameter("xml");
		log.info("1--------param----------->" + param);
		
		try {
			
			String xml = sendTextMessage("我不好");
			log.info("2--------xml----------->" + xml);
			response.getWriter().print(xml);
			
		} catch (Exception e) {
			log.error("validate方法报错，错误信息为：" + e.getMessage());
			e.printStackTrace();
		}
		
		return null;
	}
	
	public String sendTextMessage(String message){
		/**
		 * 发送消息
		 */
		StringBuffer sb = new StringBuffer();
		sb.append("<xml>");
		sb.append("<ToUserName><![CDATA[o5WyJs086iX6be9QL_JNnaxcDJlQ]]></ToUserName>");
		sb.append("<FromUserName><![CDATA[wx67f4937f4fe4160c]]></FromUserName>");
		sb.append("<CreateTime>12345678</CreateTime>");
		sb.append("<MsgType><![CDATA[text]]></MsgType>");
		sb.append("<Content><![CDATA[#message#]]></Content>");
		sb.append("</xml>");
		
		String xml = sb.toString();
		xml = xml.replaceAll("#message#", message);
		
		return xml;
	}
	
	public boolean validateTruth(HttpServletRequest request, HttpServletResponse response){
		/**
		 * 验证消息真实性
		 */
		String signature = request.getParameter("signature");
		String timestamp = request.getParameter("timestamp");
		String nonce = request.getParameter("nonce");
		String echostr = request.getParameter("echostr");
		log.info("signature----------->" + signature);
		log.info("timestamp----------->" + timestamp);
		log.info("nonce----------->" + nonce);
		log.info("echostr----------->" + echostr);
		
		if(StringUtils.isBlank(signature) || StringUtils.isBlank(timestamp) 
				|| StringUtils.isBlank(nonce) || StringUtils.isBlank(echostr)){
			log.info("参数存在空值");
			return false;
		}
		
		try {
			String[] params = {"weixin", timestamp, nonce};
			Arrays.sort(params);
			log.info("字典排序后的数组：" + Arrays.toString(params));
			
			String str = params[0] + params[1] + params[2];
			
			String newSignature = EncryptUtil.SHA1(str);
			log.info("3个参数进行加密后，得到的新字符串是：" + newSignature);
			
			if(signature.equals(newSignature)){
				log.info("两个字符串进行对比：OK");
				return true;
			}
			
		} catch (Exception e) {
			log.error("validate方法报错，错误信息为：" + e.getMessage());
			e.printStackTrace();
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		
		StringBuffer sb = new StringBuffer();
		sb.append("<xml>");
		sb.append("<ToUserName><![CDATA[o5WyJs086iX6be9QL_JNnaxcDJlQ]]></ToUserName>");
		sb.append("<FromUserName><![CDATA[wx67f4937f4fe4160c]]></FromUserName>");
		sb.append("<CreateTime>12345678</CreateTime>");
		sb.append("<MsgType><![CDATA[text]]></MsgType>");
		sb.append("<Content><![CDATA[#message#]]></Content>");
		sb.append("</xml>");
		
		String xml = sb.toString();
		xml = xml.replaceAll("#message#", "你好");
		
		System.out.println(xml);
		
	}
	
}
