 public abstract class AbstractCDOTest extends AbstractTransportTest{  protected IManagedContainer createContainer()   {  IManagedContainer container = super.createContainer();  CDOUtil.prepareContainer(container, true);  CDOServerUtil.prepareContainer(container, new ContainerRepositoryProvider(container));  CDOServerUtil.addRepository(container, createRepository());  return container; } } 
