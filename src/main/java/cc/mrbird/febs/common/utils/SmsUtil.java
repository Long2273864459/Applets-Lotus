package cc.mrbird.febs.common.utils;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.google.gson.Gson;
import org.apache.http.HttpResponse;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import org.apache.http.util.EntityUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Prock.Liy
 * @Date 2021/3/16 16:12
 * @Descripttion
 * @Version 1.0
 */
public class SmsUtil {


//    public boolean smsSend() throws Exception{
//        //设置超时时间-可自行调整
//        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
//        System.setProperty("sun.net.client.defaultReadTimeout", "10000");
//        //初始化ascClient需要的几个参数
//        final String product = "Dysmsapi";//短信API产品名称（短信产品名固定，无需修改）
//        final String domain = "dysmsapi.aliyuncs.com";//短信API产品域名（接口地址固定，无需修改）
//        //替换成你的AK
//        final String accessKeyId = "203921425";//你的accessKeyId,参考本文档步骤2
//        //你的accessKeySecret，参考本文档步骤2
//        final String accessKeySecret = "6w3hyFvNLBbOUCDLjn9k2SJkT3OsDzfl";
//        //初始化ascClient,暂时不支持多region（请勿修改）
//        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId,
//                accessKeySecret);
//        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
//        IAcsClient acsClient = new DefaultAcsClient(profile);
//
//        //组装请求对象
//        SendSmsRequest request = new SendSmsRequest();
//        //使用post提交
//        request.setMethod(MethodType.POST);
//        //必填:待发送手机号。支持以逗号分隔的形式进行批量调用，批量上限为1000个手机号码,批量调用相对于单条调用及时性稍有延迟,验证码类型的短信推荐使用单条调用的方式；发送国际/港澳台消息时，接收号码格式为国际区号+号码，如“85200000000”
//        request.setPhoneNumbers("1500000000");
//        //必填:短信签名-可在短信控制台中找到
//        request.setSignName("云通信");
//        //必填:短信模板-可在短信控制台中找到，发送国际/港澳台消息时，请使用国际/港澳台短信模版
//        request.setTemplateCode("SMS_1000000");
//        //可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
//        //友情提示:如果JSON中需要带换行符,请参照标准的JSON协议对换行符的要求,比如短信内容中包含\r\n的情况在JSON中需要表示成\\r\\n,否则会导致JSON在服务端解析失败
////参考：request.setTemplateParam("{\"变量1\":\"值1\",\"变量2\":\"值2\",\"变量3\":\"值3\"}")
//        request.setTemplateParam("{\"name\":\"Tom\", \"code\":\"123\"}");
//        //可选-上行短信扩展码(扩展码字段控制在7位或以下，无特殊需求用户请忽略此字段)
//        //request.setSmsUpExtendCode("90997");
//
//        //可选:outId为提供给业务方扩展字段,最终在短信回执消息中将此值带回给调用者
//        request.setOutId("yourOutId");
//
//        //请求失败这里会抛ClientException异常
//        SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
//        if(sendSmsResponse.getCode() != null && sendSmsResponse.getCode().equals("OK")) {
//            //请求成功
//            System.out.println("发送成功!");
//        }
//        return true;
//    }
//
//    public static void main(String[] args) throws Exception {
//        String host = "http://yzx.market.alicloudapi.com";
//        String path = "/yzx/sendSms";
//        String method = "POST";
//        String appcode = "666ebf370bc44966a29aa649b97ab398";
//        Map<String, String> headers = new HashMap<String, String>();
//        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
//        headers.put("Authorization", "APPCODE " + appcode);
//        Map<String, String> querys = new HashMap<String, String>();
//        querys.put("mobile", "18569436426");
//        querys.put("param", "code:666ebf370bc44966a29aa649b97ab398");
//        querys.put("tpl_id", "TP1710262");
//        Map<String, String> bodys = new HashMap<String, String>();
//
//
//        try {
//            /**
//             * 重要提示如下:
//             * HttpUtils请从
//             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
//             * 下载
//             *
//             * 相应的依赖请参照
//             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
//             */
//            HttpResponse response = HttpUtil.doPost(host, path, method, headers, querys, bodys);
//            System.out.println(response.toString());
//            //获取response的body
//            System.out.println(EntityUtils.toString(response.getEntity()));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//
//    //---------------------------------------------------------------------------------------------
//
//    /**
//     * 设置公共请求参数，初始化Client。
//     */
//    private DefaultProfile profile = DefaultProfile.getProfile(
//            // API支持的地域ID，如短信API的值为：cn-hangzhou。
//            "cn-shanghai",
//            "203921425",// 您的AccessKey ID。
//            "6w3hyFvNLBbOUCDLjn9k2SJkT3OsDzfl");// 您的AccessKey Secret。
//    private IAcsClient client = new DefaultAcsClient(profile);
//
//    private static void log_print(String functionName, Object result) {
//        Gson gson = new Gson();
//        System.out.println("-------------------------------" + functionName + "-------------------------------");
//        System.out.println(gson.toJson(result));
//    }
//
//    /**
//     * 添加短信模板
//     */
//    private String addSmsTemplate() throws ClientException {
//        CommonRequest addSmsTemplateRequest = new CommonRequest();
//        addSmsTemplateRequest.setSysDomain("dysmsapi.aliyuncs.com");
//        addSmsTemplateRequest.setSysAction("AddSmsTemplate");
//        addSmsTemplateRequest.setSysVersion("2021-05-25");
//        // 短信类型。0：验证码；1：短信通知；2：推广短信；3：国际/港澳台消息
//        addSmsTemplateRequest.putQueryParameter("TemplateType", "0");
//        // 模板名称，长度为1~30个字符
//        addSmsTemplateRequest.putQueryParameter("TemplateName", "测试短信模板");
//        // 模板内容，长度为1~500个字符
//        addSmsTemplateRequest.putQueryParameter("TemplateContent", "您正在申请手机注册，验证码为：${code}，5分钟内有效！");
//        // 短信模板申请说明
//        addSmsTemplateRequest.putQueryParameter("Remark", "测试");
//        CommonResponse addSmsTemplateResponse = client.getCommonResponse(addSmsTemplateRequest);
//        String data = addSmsTemplateResponse.getData();
//        // 消除返回文本中的反转义字符
//        String sData = data.replaceAll("'\'", "");
//        log_print("addSmsTemplate", sData);
//        Gson gson = new Gson();
//        // 将字符串转换为Map类型，取TemplateCode字段值
//        Map map = gson.fromJson(sData, Map.class);
//        Object templateCode = map.get("TemplateCode");
//        return templateCode.toString();
//    }
//
//    /**
//     * 发送短信
//     */
//    private String sendSms(String templateCode) throws ClientException {
//        CommonRequest request = new CommonRequest();
//        request.setSysDomain("dysmsapi.aliyuncs.com");
//        request.setSysVersion("2017-03-17");
//        request.setSysAction("SendSms");
//        // 接收短信的手机号码
//        request.putQueryParameter("PhoneNumbers", "185");
//        // 短信签名名称。请在控制台签名管理页面签名名称一列查看（必须是已添加、并通过审核的短信签名）。
//        request.putQueryParameter("SignName", "阿里云通信");
//        // 短信模板ID
//        request.putQueryParameter("TemplateCode", templateCode);
//        // 短信模板变量对应的实际值，JSON格式。
//        request.putQueryParameter("TemplateParam", "{\"code\":\"8888\"}");
//        CommonResponse commonResponse = client.getCommonResponse(request);
//        String data = commonResponse.getData();
//        String sData = data.replaceAll("'\'", "");
//        log_print("sendSms", sData);
//        Gson gson = new Gson();
//        Map map = gson.fromJson(sData, Map.class);
//        Object bizId = map.get("BizId");
//        return bizId.toString();
//    }
}
