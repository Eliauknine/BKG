  content.setLayout(GridLayoutFactory.fillDefaults().margins(10, 10).create()); content.setLayoutData(GridDataFactory.fillDefaults().create());  final VView view = ViewProviderHelper.getView(dummyObject,  VViewFactory.eINSTANCE.createViewModelLoadingProperties());  final ViewModelContext viewModelContext = ViewModelContextFactory.INSTANCE.createViewModelContext(view,  dummyObject, new DefaultReferenceService(), new EMFDeleteServiceImpl());  render = ECPSWTViewRenderer.INSTANCE.render(content, viewModelContext);  content.layout(); }
