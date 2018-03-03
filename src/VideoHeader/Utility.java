package VideoHeader;


public class Utility
{
    public static int ByteArrayToint(byte[] paramArrayOfByte)
    {
        int j = 0;
        int i = 3;
        for (i=3;;)
        {
            if (i < 0) {
                return j;
            }
            j = j << 8 | paramArrayOfByte[i] & 0xFF;
            i -= 1;
        }
    }

    static int Int2inthtonl(int paramInt)
    {
        byte[] arrayOfByte = new byte[4];
        arrayOfByte[0] = ((byte)(paramInt & 0xFF));
        arrayOfByte[1] = ((byte)((0xFF00 & paramInt) >> 8));
        arrayOfByte[2] = ((byte)((0xFF0000 & paramInt) >> 16));
        arrayOfByte[3] = ((byte)((0xFF000000 & paramInt) >> 24));
        return ((arrayOfByte[0] & 0xFF) << 24) + ((arrayOfByte[1] & 0xFF) << 16) + ((arrayOfByte[2] & 0xFF) << 8) + arrayOfByte[3];
    }

    public static byte[] IntShort2byteArray(int paramInt)
    {
        byte[] arrayOfByte = new byte[4];
        arrayOfByte[3] = ((byte)(paramInt & 0xFF));
        arrayOfByte[2] = ((byte)((0xFF00 & paramInt) >> 8));
        arrayOfByte[1] = ((byte)((0xFF0000 & paramInt) >> 16));
        arrayOfByte[0] = ((byte)((0xFF000000 & paramInt) >> 24));
        return new byte[] { arrayOfByte[3], arrayOfByte[2], arrayOfByte[1], arrayOfByte[0] };
    }

    public static byte[] IntShort2byteArray(short paramShort)
    {
        byte[] arrayOfByte = new byte[2];
        arrayOfByte[1] = ((byte)(paramShort & 0xFF));
        arrayOfByte[0] = ((byte)((0xFF00 & paramShort) >> 8));
        return new byte[] { arrayOfByte[1], arrayOfByte[0] };
    }

    public static byte[] decodeArray(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
        byte[] arrayOfByte = new byte[paramInt2];
        int j = paramInt1;
        int i = 0;
        for (;;)
        {
            if (j >= paramInt1 + paramInt2) {
                return arrayOfByte;
            }
            arrayOfByte[i] = paramArrayOfByte[j];
            j += 1;
            i += 1;
        }
    }

    public static byte decodeByte(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
        return paramArrayOfByte[paramInt1];
    }

    public static char decodeChar(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
        return (char)paramArrayOfByte[paramInt1];
    }

    public static int decodeInt(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
        int j = 0;
        int i = 0;
        int k = paramInt1;
        for (;;)
        {
            int m = i;
            if (k >= paramInt2 + paramInt1) {
                return j;
            }
            int n = paramArrayOfByte[k];
            i = m + 1;
            j += ((n & 0xFF) << m * 8);
            k += 1;
        }
    }

    public static short decodeShort(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
        int i = 0;
        int k = 0;
        int m = paramInt1;
        for (;;)
        {
            int n = k;
            if (m >= paramInt2 + paramInt1) {
                return (short) i;
            }
            int i1 = paramArrayOfByte[m];
            k = n + 1;
            int j = (short)(((i1 & 0xFF) << n * 8) + i);
            m += 1;
        }
    }

    public static byte[] htonl(int paramInt)
    {
        int i = (byte)(paramInt & 0xFF);
        int j = (byte)((0xFF00 & paramInt) >> 8);
        int k = (byte)((0xFF0000 & paramInt) >> 16);
        return new byte[] { (byte)((0xFF000000 & paramInt) >> 24), (byte) k, (byte) j, (byte) i};
    }

    public class DvrAlarmSetting
    {
        byte[] AlarmONorOFF = new byte[6];
        byte[] SupportAlarm = new byte[6];

        public DvrAlarmSetting() {}
    }

    public static class Owsp_DATE
    {
        public byte m_day = 0;
        public byte m_month = 0;
        public short m_year = 0;
    }

    public static class Owsp_TIME
    {
        public byte m_hour = 0;
        public byte m_microsecond = 0;
        public byte m_minute = 0;
        public byte m_second = 0;
    }

    public class VideoSetting
    {
        byte[] SupportVideoQuality = new byte[6];
        byte[] SupportVideoSize = new byte[7];
        byte[] Supportvideoporn = new byte[2];
        int VideoFrameRate;
        int VideoQuality;
        int VideoSize;
        byte Videoporn;

        public VideoSetting() {}
    }
}