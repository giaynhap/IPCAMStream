package VideoHeader;

public class AudioHeader {
    public int bitrate;
    public short bitsPerSample;
    public  short blockAlign;
    public short chanelNumber;
    public short frameInterval;
    public short reserve;
    public int samplesPerSecond;
    public short waveFormat;
    public String toString()
    {
        return "Bit rate: "+this.bitrate+", BitsPerSample: "+this.bitsPerSample+", blockAlign: "+this.blockAlign+", channelNumber: "+this.chanelNumber+", reserve: "+this.reserve+", samplesPerSecond: "+this.samplesPerSecond+", waveFormat: "+this.waveFormat+", frameInterval "+this.frameInterval+",reserver: "+this.reserve;

    }
}
