 public Activator(){     { super(BUNDLE);     }  @Override  protected void doStart() throws Exception     {  new HibernateCommandProvider(bundleContext);     }   } 
