# Animal

###Práctica Web Scrapping

####Con la utilización de Selenium web driver he conseguido scrapear la pagina web de BioParcValencia, es una pagina web de un famoso parque zoologico, en el cual reune bastante informacion de distintas zonas del mundo y de los animales que habitan en ella.
##### El codigo empieza en el main donde navegamos hasta la pagina donde se encuentran las distantas zonas, aqui scrapeo el nombre, la descripcion y el enlace de cada zona para luego ir a la pagina donde se enceuntran todos los animales, una vez navego al primer enlace scrapeo solo los enlaces de cada animal para luego navegar a cada animal y scrapear distintas descripciones. Cada animal tiene dos partes que scrapear la primera consta de nombre, especie,clase etc... y cada fragmento recoge el propio titulo, asi que he utilizado una clase llamada CodeCracker para que elimine el primer tag </p/> pasandole el propio tag. La segunda parte que scrapear