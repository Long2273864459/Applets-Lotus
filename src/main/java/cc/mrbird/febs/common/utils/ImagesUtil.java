package cc.mrbird.febs.common.utils;

import net.coobird.thumbnailator.Thumbnails;
import org.apache.commons.codec.binary.Base64;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.*;

/**
 * @Author Prock.Liy
 * @Date 2021/3/2 17:58
 * @Descripttion 图片流公共类，用于返回前端图片流
 * @Version 1.0
 */
public class ImagesUtil {

    /**
     * @see
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String r = request.getParameter("r");
        //使用字节流读取本地图片
        ServletOutputStream out=null;
        BufferedInputStream buf=null;
        //创建一个文件对象，对应的文件就是python把词云图片生成后的路径以及对应的文件名
        File file = new File("/opt/app/wechat/images/微信图片_20210309215058.png");
        try {
            //使用输入读取缓冲流读取一个文件输入流
            buf=new BufferedInputStream(new FileInputStream(file));
            //利用response获取一个字节流输出对象
            out=response.getOutputStream();
            //定义个数组，由于读取缓冲流中的内容
            byte[] buffer=new byte[1024];
            //while循环一直读取缓冲流中的内容到输出的对象中
            while(buf.read(buffer)!=-1) {
                out.write(buffer);
            }
            //写出到请求的地方
            out.flush();
        }catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }finally {
            if(buf!=null) buf.close();
            if(out!=null) out.close();
        }
        //传输结束后，删除文件，可以不删除，在生成的图片中回对此进行覆盖
        File file1 = new File("E:\\Java\\eclipse_code\\NLP\\WebContent\\source\\wordcloud.png");
        file1.delete();
        System.out.println("文件删除！");
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

    /**
     * 本地文件（图片、excel等）转换成Base64字符串
     *
     * @param imgPath
     */
    public static String convertFileToBase64(String imgPath) {
        byte[] data = null;
        // 读取图片字节数组
        try {
            InputStream in = new FileInputStream(imgPath);
            System.out.println("文件大小（字节）="+in.available());
            data = new byte[in.available()];
            in.read(data);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 对字节数组进行Base64编码，得到Base64编码的字符串
        BASE64Encoder encoder = new BASE64Encoder();
        String base64Str = encoder.encode(data);
        return base64Str;
    }

}
