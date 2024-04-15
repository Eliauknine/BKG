 [/if]  */ [/if] enum [name/] { [let seq : Sequence(uml::NamedElement) = ownedElement->asSequence()->filter(uml::EnumerationLiteral)]     [seq->genEnumLiteral()/] [/let] } }
