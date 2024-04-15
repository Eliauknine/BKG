  playLoop(behavior); isPlayed = true; 		}  while(wait && !this.tridentTimeline.isDone()) {  try {  Thread.sleep(500); 			} catch (InterruptedException e) {  break; 			} 		} 	}
