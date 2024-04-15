  for (final ProjectSpace projectSpace : getProjectSpaces()) {			((ProjectSpaceBase) projectSpace).dispose(); 		}  getServerInfos().clear();  getUsersessions().clear();  save(); 	}
