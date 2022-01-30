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

        String name;
        String rol;
        String historia;

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

            this.name = name;
            this.rol = rol;
            this.historia = historia;
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

        public String getName() {
            return name;
        }

        public String getRol() {
            return rol;
        }

        public String getHistoria() {
            return historia;
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

        public void setOrden(String orden) {
            this.orden = orden;
        }

        public void setClase(String clase) {
            this.clase = clase;
        }

        public void setHabitat(String habitat) {
            this.habitat = habitat;
        }

        public void setDieta(String dieta) {
            this.dieta = dieta;
        }

        public void setGestacion(String gestacion) {
            this.gestacion = gestacion;
        }

        public void setNumeroDeCrias(String numeroDeCrias) {
            this.numeroDeCrias = numeroDeCrias;
        }

        public void setVida(String vida) {
            this.vida = vida;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setRol(String rol) {
            this.rol = rol;
        }

        public void setHistoria(String historia) {
            this.historia = historia;
        }
    }
