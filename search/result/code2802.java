 @Override  public Message createBusinessObject(ICreateContext context) {  Message message = null;  message = Bpmn2ModelerFactory.create(Message.class);  String oldName = message.getName(); } 
