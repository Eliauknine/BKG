  Type val = null; try {  if (ctx.getCallback() != null) {  ctx.getCallback().pre(this, ctx); 			}  val = analyzeInternal(ctx, issues);  return val; } }
