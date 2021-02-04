package mr.design.util;

import com.google.common.annotations.VisibleForTesting;
import mr.design.exception.IdGenerationException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Random;

public class RandomIdGenerator implements LogTraceIdGenerator {


    @Override
    public String generate() {
        String substrOfHostName;
        try {
            substrOfHostName = getLastFieldOfHostname();
        } catch (UnknownHostException e) {
            throw new IdGenerationException("host name is empty");
        }

        long currentTimeMillis = System.currentTimeMillis();
        String randomString = generateRandomAlphameric(8);

        return String.format("%s-%d-%s", substrOfHostName, currentTimeMillis, randomString);
    }


    private String getLastFieldOfHostname() throws UnknownHostException {
        String hostName = InetAddress.getLocalHost().getHostName();
        if (hostName == null || hostName.isEmpty()) {
            throw new UnknownHostException();
        }
        return getLastSubstrSplittedByDot(hostName);
    }

    @VisibleForTesting
    protected String getLastSubstrSplittedByDot(String hostName) {
        if (hostName == null || hostName.isEmpty()) {
            throw new IllegalArgumentException("hostName is empty");
        }
        String[] tokens = hostName.split("\\.");
        return tokens[tokens.length - 1];
    }

    @VisibleForTesting
    protected String generateRandomAlphameric(int length) {
        char[] randomChars = new char[length];
        int count = 0;
        Random random = new Random();
        while (count < length) {
            int maxAscii = 'z';
            int randomAscii = random.nextInt(maxAscii);
            boolean isDigit = randomAscii >= '0' && randomAscii <= '9';
            boolean isUppercase = randomAscii >= 'A' && randomAscii <= 'Z';
            boolean isLowercase = randomAscii >= 'a' && randomAscii <= 'z';
            if (isDigit || isUppercase || isLowercase) {
                randomChars[count] = (char) randomAscii;
                count++;
            }
        }
        return new String(randomChars);
    }
}
