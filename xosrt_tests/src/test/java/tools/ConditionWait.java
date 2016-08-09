package tools;

public class ConditionWait {
	public static interface Condition {
		public boolean check();
	}
	
	private static final int MICRO_WAIT_TIME = 30;
	private static final int DEFAULT_WAIT_TIME = 10000;

    public static boolean till(Condition cond, long timeUpMsec) {
        long startTime = System.currentTimeMillis();
        while (System.currentTimeMillis() < startTime + timeUpMsec) {
            try {
                Thread.sleep(MICRO_WAIT_TIME);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            if (cond.check()) return true;
        }
        return false;
    }

    public static boolean till(Condition cond) {
        return tillGlobalTime(cond, DEFAULT_WAIT_TIME);
    }

    private static long GLOBAL_START_TIME = 0;
	public static boolean tillGlobalTime(Condition cond, long timeUpMsec) {
        if (GLOBAL_START_TIME == 0) {
            System.currentTimeMillis();
            GLOBAL_START_TIME = System.currentTimeMillis();
        }
        long startTime = GLOBAL_START_TIME;
		do {
			try {
				Thread.sleep(MICRO_WAIT_TIME);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (cond.check()) return true;
		} while (System.currentTimeMillis() < startTime + timeUpMsec);
		return false;
	}

	public static boolean tillGlobalTime(Condition cond) {
		return tillGlobalTime(cond, DEFAULT_WAIT_TIME);
	}

    public static boolean since(Condition cond, long since) {
        try {
            Thread.sleep(since);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return cond.check();
    }

    public static boolean since(Condition cond) { return since(cond, DEFAULT_WAIT_TIME); }

    public static boolean sinceTill(final Condition cond, long since, final long till) {

        return since(new Condition() {
            @Override
            public boolean check() {
                return tillGlobalTime(cond, till);
            }
        }, since);
    }

    public static void prepareConditionWait() {
        GLOBAL_START_TIME = 0;
    }
}
