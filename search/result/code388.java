   CComLayer *newLayer = 0;  CComLayer *previousLayer = 0; // Reference to the previous layer as it needs to set the bottom layer  char *layerParams = 0;  // Loop until reaching the end of the ID  while ('\0' != *commID) {  // Get the next layer's ID and parameters  char * layerID = extractLayerIdAndParams(&commID, &layerParams);  // If not well formated ID return an error  if(0 == commID){  if('\0' != *layerID) {         retVal = e_InitInvalidId;       }  break;     }  // Create the new layer     newLayer = CComLayersManager::createCommunicationLayer(layerID, previousLayer, this);  if (0 == newLayer) {  // If the layer can't be created return an error       retVal = e_InitInvalidId;  break;     }  else if (0 == m_poTopOfComStack) {  // Assign the newly created layer to the FB       m_poTopOfComStack = newLayer;     }  // Update the previous layer reference     previousLayer = newLayer;  // Open the layer connection     retVal = newLayer->openConnection(layerParams);  if (e_InitOk != retVal) {  // If it was not opened correctly return the error  break;     }   } }
