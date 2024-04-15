 return LicensingResults.createError(task, source, errors);	}  public static List<Path> collectPacks(Path configurationPath, String... extensions) throws LicensingException {  String message = String.format("Failed to collect packs at %s", configurationPath);  String source = ConditionMiners.class.getName();  if (configurationPath == null) {  IllegalArgumentException e = new IllegalArgumentException();  throw new LicensingException(LicensingResults.createError(message, source, e)); 		}  List<Path> licenseFiles = new ArrayList<>();  try {  Files.walkFileTree(configurationPath, new SimpleFileVisitor<Path>() {  @Override  public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {  String lowerCase = file.toString().toLowerCase();  for (String extension : extensions) {  if (lowerCase.endsWith(extension)) {  licenseFiles.add(file); 						} 					}  return FileVisitResult.CONTINUE; } } } 
