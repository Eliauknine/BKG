 @Override  public void service() throws IOException, ServletException {  HttpServletResponse response = RWT.getResponse();  if (StringUtility.hasText(m_contentType)) {  response.setContentType(m_contentType);     } } 
