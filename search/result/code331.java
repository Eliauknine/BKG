 $this->warnings[] = $warning; return $return;     }    public function start()     {  $this->warnings = array();  parent::start();     }    public function stop()     {  parent::stop(); 
