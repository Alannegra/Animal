# Animal

### Práctica Web Scrapping

#### Con la utilización de Selenium web driver he conseguido scrapear la pagina web de BioParcValencia, es una pagina web de un famoso parque zoologico, la cual reune bastante informacion de distintas zonas del mundo y de los animales que habitan en ella.
### Code
##### El codigo empieza en el main donde navegamos hasta la pagina donde se encuentran las distantas zonas, aqui scrapeo el nombre, la descripcion y el enlace de cada zona para luego ir a la pagina donde se enceuntran todos los animales, una vez navego al primer enlace scrapeo solo los enlaces de cada animal para luego navegar a cada animal y scrapear distintas descripciones. Cada animal tiene dos partes que scrapear la primera consta de nombre, especie,clase etc... y cada fragmento recoge el propio titulo, asi que he utilizado una clase llamada CodeCracker para que elimine el primer tag </p/> pasandole el propio tag. La segunda parte que scrapear he utilizado la misma tecnia de el principio de hacer clic en el boton de aceptar las cookies para hacer clic en las diferentes pestañas del animal. Finalmente construyo dos csv con el material scrapeado uno de las zonas y otro de los animales y construyo un xml con JAXB con ambos scrapeos. A la hora de scrapear he utilizado tres clases para guardar los datos lo mismo para hacer el XML.
> JavaDoc https://alannegra.github.io/Animal/
