@SuppressWarnings("restriction")public class ViewModelSelectControlSWTRenderer extends EditableEReferenceLabelControlSWTRenderer {  /** 	 * @author Eugen 	 *  	 */  private static final class EClassSelectionContentProvider implements ITreeContentProvider {  @Override  public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {  // do nothing 		}  @Override  public void dispose() {  // do nothing 		}  @Override  public boolean hasChildren(Object element) {  if (EPackage.Registry.class.isInstance(element)) {  return true; 			}  if (EPackage.Descriptor.class.isInstance(element)) {  return true; 			}  if (EPackage.class.isInstance(element)) {  return true; 			}  return false; 		}  @Override  public Object getParent(Object element) {  if (EObject.class.isInstance(element)) {  return EObject.class.cast(element).eContainer(); 			}  return null; 		}  @Override  public Object[] getElements(Object inputElement) {  return getChildren(inputElement); 		}  @Override  public Object[] getChildren(Object parentElement) {  if (EPackage.Registry.class.isInstance(parentElement)) {  final List<Object> result = new ArrayList<Object>();  for (final Object object : EPackage.Registry.class.cast(parentElement).values()) {  if (EPackage.Descriptor.class.isInstance(object)) {  result.add(EPackage.Descriptor.class.cast(object).getEPackage()); 					}  else {  result.add(object); 					} 				}  Collections.sort(result, new Comparator<Object>() {  @Override  public int compare(Object object1, Object object2) {  if (EPackage.class.isInstance(object1) && EPackage.class.isInstance(object2)) {  return EPackage.class.cast(object1).getName() 								.compareTo(EPackage.class.cast(object2).getName()); 						}  return object1.toString().compareTo(object2.toString()); 					} 				});  return result.toArray(); 			}  if (EPackage.Descriptor.class.isInstance(parentElement)) {  return getChildren(EPackage.Descriptor.class.cast(parentElement).getEPackage()); 			}  if (EPackage.class.isInstance(parentElement)) {  return EPackage.class.cast(parentElement).getEClassifiers().toArray(); 			}  return null; 		} 	}  private static final String PLUGIN_ID = "org.eclipse.emf.ecp.view.template.tooling";   /** } 
