 public static final int EOBJECT__NO_CIRCULAR_CONTAINMENT = 15;  public static final int EOBJECT__EVERY_BIDIRECTIONAL_REFERENCE_IS_PAIRED = 16;  static final int EOBJECT_DIAGNOSTIC_CODE_COUNT = EOBJECT__NO_CIRCULAR_CONTAINMENT;  /**    * A key to be used in <code>context</code> maps to indicate the root object at which validation started.    * It's used to detect {@link #EOBJECT__NO_CIRCULAR_CONTAINMENT circular containment}    * and to prevent {@link Diagnostician#validate(EClass, EObject, DiagnosticChain, Map) infinite recursion}.    * The value of the entry must be the root{@link EObject}.    * @see EValidator#validate(EObject, DiagnosticChain, Map)    * @see #validate_NoCircularContainment(EObject, DiagnosticChain, Map)    * @since 2.5 
