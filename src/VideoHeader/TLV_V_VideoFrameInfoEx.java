package VideoHeader;


final class TLV_V_VideoFrameInfoEx
{
    byte channelId;
    short checksum;
    int dataSize;
    int frameIndex;
    byte reserve;
    int time;
}
