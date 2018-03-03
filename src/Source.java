import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.Socket;

import org.jcodec.codecs.h264.H264Decoder;

import org.jcodec.common.io.NIOUtils;
import org.jcodec.containers.mp4.demuxer.MP4Demuxer;
import org.jcodec.containers.mxf.MXFDemuxer;
import org.jcodec.containers.webp.WebpDemuxer;
import org.jcodec.containers.y4m.Y4MDemuxer;

import static java.io.FileDescriptor.in;

public class Source
{

    private static Socket socket;
    private static DataInputStream dis;
    private static DataOutputStream dos;
    public static void main(String[] args)
    {

        Source source =  new Source() ;
       // source.display();
        source.dologin();


        H264Decoder decoder = new H264Decoder();
    }

    public void display()
    {

        JFrame form = new JFrame();
        form.setVisible(true);
        form.setSize(1024,768);
        form.setLayout(null);
        display dis_ = new display();
        form.getContentPane().add(dis_);
        dis_.setSize(1024,768);

    }

    class display extends  JPanel{

        private BufferedImage canvas = new BufferedImage(1024,768,BufferedImage.TYPE_4BYTE_ABGR);
        public display(){
            JLabel lb = new JLabel(new ImageIcon(canvas));

            this.add(lb);

            Graphics2D grap = canvas.createGraphics();
            grap.setBackground(Color.RED);
            grap.clearRect(0,0,10240,768);
        }
    }

    public void dologin()
    {
        try {
            socket = new Socket("camerarainbow.dyndns.org", 8888);
            dos = new DataOutputStream(socket.getOutputStream());
            dis = new DataInputStream(socket.getInputStream());

            byte [] login =makePackLogin().toByteArray();

            dos.write(login);







            (new revDataClass()).start();
            //
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ByteArrayOutputStream makePackLogin() throws IOException {
        ByteArrayOutputStream  byteStream = new ByteArrayOutputStream();

        DataOutputStream out = new DataOutputStream(byteStream);
        out.write(getLoginByte());
        out.write(stringtobyte32("user",32));
        out.write(stringtobyte32("1102",21));
        byte [] mb = {1,0,0};
        out.write( mb);
        /*
        for (int k : byteStream.toByteArray())
        {
            System.out.print(k);
        }
        */
        return byteStream;
    }
    public byte[] stringtobyte32(String str,int nbyte)
    {
        byte[] rtn = new byte[nbyte];

        char [] str_char = str.toCharArray();


        for ( int i =0 ; i < str_char.length;i++ )
        {
            rtn[i]= (byte) str_char[i];
        }
        return  rtn;

    }

    class revDataClass implements Runnable{

        public void start()
        {
            new Thread(this).start();
        }
        @Override
        public void run() {
            OutputStream out = null;
            File file = new File("E:\\stream.raw");
            try {
                  out = new FileOutputStream(file);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            while(true) {
        byte [] revByte = new byte[1024];
             try {
                Thread.sleep(0);

                 //revDataFromServer();

              dis.read(revByte);
                 out.write(revByte);
              //   System.out.println(bytesToHex(revByte));



             } catch (InterruptedException e) {
                 e.printStackTrace();
             } catch (IOException e) {
                 e.printStackTrace();
             }
         }
        }
    }
    public void revDataFromServer() throws IOException
    {

      // readJPG();
    while (true)
        {
            System.out.println(dis.readByte()); // videoChannel
            System.out.println(dis.readByte()); // audioChannel
            System.out.println(dis.readByte()); // dataType
            System.out.println(dis.readByte()); // reserve
            System.out.println(dis.readInt());  // codeid
            System.out.println(dis.readShort());  // bitrate
            System.out.println(dis.readShort());  // width
            System.out.println(dis.readShort());  // height
            System.out.println(dis.readByte()); // framerate
            System.out.println(dis.readByte());//  colorDepth
            System.out.println(dis.readShort()); // reserve

        }

    }
    public static byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                    + Character.digit(s.charAt(i+1), 16));
        }
        return data;
    }
    public static byte[] getLoginByte()
    {
       String str = "0000004800000000280004000500000029003800";
        return hexStringToByteArray(str);
    }
    private final static char[] hexArray = "0123456789ABCDEF".toCharArray();
    public static String bytesToHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        for ( int j = 0; j < bytes.length; j++ ) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        return new String(hexChars);
    }
    //0000000048000000002800040005000000290038007573657200000000000000000000000000000000000000000000000000000000313130320000000000000000000000000000000000010000

    int counter = 0;
    BufferedImage image;

}
