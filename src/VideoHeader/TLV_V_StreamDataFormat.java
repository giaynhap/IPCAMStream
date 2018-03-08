package VideoHeader;

public final class TLV_V_StreamDataFormat
{
    public   byte audioChannel;
    public AudioHeader audioFormat = new AudioHeader();
    public  byte dataType;
    public  byte reserve;
    public byte videoChannel;
    public VideoHeader videoFormat = new VideoHeader();
    public String toString()
    {
        return "videoFormat:["+this.videoFormat.toString()+"],[audioFormat: "+audioFormat.toString()+"], dataType: "+this.dataType+", VideoChannel: "+this.videoChannel+", reserve: "+this.reserve;
    }

}
