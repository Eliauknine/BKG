 public class CDOViewImpl extends org.eclipse.net4j.util.event.Notifier implement{  private ChangeSubscriptionManager changeSubscriptionManager = createChangeSubscriptionManager();  private ViewAdapterManager adapterPolicyManager = createAdapterManager();  private CDOAdapterPolicy changeSubscriptionPolicy = CDOAdapterPolicy.NONE; } 
