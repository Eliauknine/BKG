		} finally {  if (ctx.getCallback() != null) {  ctx.getCallback().post(null); 			} 		} 	}  public final void analyze(final XpandExecutionContext ctx, final Set<AnalysationIssue> issues) {  try {  if (ctx.getCallback() != null) {  ctx.getCallback().pre(this, ctx); 			}  analyzeInternal(ctx, issues); 		
