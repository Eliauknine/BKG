 */public class ManagedContainer extends Lifecycle implements IManagedContainer {  private IRegistry<IFactoryKey, IFactory> factoryRegistry;  private List<IElementProcessor> postProcessors; } 
