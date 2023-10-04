public class CyberSecuritySystem {
    private double userBalance;
    private boolean userAccess;

    public CyberSecuritySystem(double initialBalance) {
        userBalance = initialBalance;
        userAccess = false;
    }

    // ব্যবহারকারী অ্যাক্সেস দেওয়ার মেথড
    public void grantAccess() {
        userAccess = true;
    }

    // ব্যবহারকারী অ্যাক্সেস বাতিল করার মেথড
    public void revokeAccess() {
        userAccess = false;
    }

    // ব্যবহারকারীর ব্যালেন্স প্রদর্শন করার মেথড
    public double getUserBalance() {
        if (userAccess) {
            return userBalance;
        } else {
            throw new SecurityException("Access denied. Please request access.");
        }
    }

    // ব্যবহারকারীর অ্যাক্সেস স্থিতি প্রদর্শন করার মেথড
    public boolean hasAccess() {
        return userAccess;
    }
}
