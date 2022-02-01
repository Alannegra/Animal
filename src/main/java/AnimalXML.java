import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

/**
 * Clase AnimalXML: Tiene el objetivo de guardar los datos de un animal, cambiarlos o darlos preparados para ser convertidos a XML.
 */
    @XmlRootElement(name="Animal")
    public class AnimalXML {
        String nombre;
        String especie;
        String familia;
        String orden;
        String clase;

        String habitat;
        String dieta;
        String gestacion;
        String numeroDeCrias;
        String vida;

    /**
     * Constructor para construir un AnimalXML
     * @param nombre El nombre del animal
     * @param especie La especie del animal
     * @param familia La familia del animal
     * @param orden El orden del animal
     * @param clase La clase del animal
     *
     * @param habitat El habitat del animal
     * @param dieta La dieta del animal
     * @param gestacion La gestacion del animal
     * @param numeroDeCrias El numero de crias del animal
     * @param vida La vida del animal
     */
        public AnimalXML(String nombre, String especie, String familia, String orden, String clase, String habitat, String dieta, String gestacion, String numeroDeCrias, String vida) {
            this.nombre = nombre;
            this.especie = especie;
            this.familia = familia;
            this.orden = orden;
            this.clase = clase;

            this.habitat = habitat;
            this.dieta = dieta;
            this.gestacion = gestacion;
            this.numeroDeCrias = numeroDeCrias;
            this.vida = vida;

        }

        public AnimalXML() {
        }

        public String getNombre() {
            return nombre;
        }

        public String getEspecie() {
            return especie;
        }

        public String getFamilia() {
            return familia;
        }

        public String getOrden() {
            return orden;
        }

        public String getClase() {
            return clase;
        }


        public String getHabitat() {
            return habitat;
        }

        public String getDieta() {
            return dieta;
        }

        public String getGestacion() {
            return gestacion;
        }

        public String getNumeroDeCrias() {
            return numeroDeCrias;
        }

        public String getVida() {
            return vida;
        }


        @XmlElement(name="Nombre")
        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        @XmlElement(name="Especie")
        public void setEspecie(String especie) {
            this.especie = especie;
        }

        @XmlElement(name="Familia")
        public void setFamilia(String familia) {
            this.familia = familia;
        }

        @XmlElement(name="Orden")
        public void setOrden(String orden) {
            this.orden = orden;
        }

        @XmlElement(name="Clase")
        public void setClase(String clase) {
            this.clase = clase;
        }


        @XmlElement(name="Habitat")
        public void setHabitat(String habitat) {
            this.habitat = habitat;
        }

        @XmlElement(name="Dieta")
        public void setDieta(String dieta) {
            this.dieta = dieta;
        }

        @XmlElement(name="Gestacion")
        public void setGestacion(String gestacion) {
            this.gestacion = gestacion;
        }

        @XmlElement(name="Crias")
        public void setNumeroDeCrias(String numeroDeCrias) {
            this.numeroDeCrias = numeroDeCrias;
        }

        @XmlElement(name="Vida")
        public void setVida(String vida) {
            this.vida = vida;
        }

    }
