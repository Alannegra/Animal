import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

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
