 public class Session extends Container<IView> implements ISession, CDOIDProvider{  private int sessionID;  private ConcurrentMap<Integer, View> views = new ConcurrentHashMap();  private Set<CDOID> knownObjects = new HashSet();  private IListener protocolListener = new LifecycleEventAdapter()   { } } 
