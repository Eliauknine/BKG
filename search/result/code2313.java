 @POST @Consumes("*/*")  public Response postNonRDFSource(@HeaderParam(LDPConstants.HDR_SLUG) String slug, InputStream content) {  return getRequestContainer().postNonRDFSource(content, stripCharset(fRequestHeaders.getMediaType().toString()), slug); 	}  @DELETE 
