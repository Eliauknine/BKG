 public class SessionManager extends Container<ISession> implements ISessionManag{  private Repository repository;  private Map<Integer, Session> sessions = new HashMap();  private int lastSessionID; } 
