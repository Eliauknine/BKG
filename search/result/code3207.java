	} public void play(ITimeline timeline, boolean wait) {  ScenarioManager manager = scenarioManagers.get(timeline.getTarget());  if (manager != null) {  manager.play(timeline, wait); 		} 	
