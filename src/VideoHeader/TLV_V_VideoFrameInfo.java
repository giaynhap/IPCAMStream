package VideoHeader;

final class TLV_V_VideoFrameInfo {
    byte channelId;
    short checksum;
    int dataSize;
    int frameIndex;
    byte reserve;
    int time;
}
