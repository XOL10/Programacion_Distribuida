public class Main {
    public static void main(String[] args){
        // Agrega código necesario para poder ejecutar los siguiente:
        IdentifyMyParts a = new IdentifyMyParts();
        IdentifyMyParts b = new IdentifyMyParts();
        a.y = 5;
        b.y = 6;
        a.x = 1;
        b.x = 2;
        /* Se le asigna 2 a la propiedad estática,
         * por lo tanto, las propiedades a.x e IdentifyMyParts.x
         * también tendrán valor 2*/
        System.out.println("a.y = " + a.y);
        System.out.println("b.y = " + b.y);
        System.out.println("a.x = " + a.x);
        System.out.println("b.x = " + b.x);
        System.out.println("IdentifyMyParts.x = " + IdentifyMyParts.x);
    }
}

/* Este es el resultado de las varaibles.:
 a.y = 5
 b.y = 6
 a.x = 2
 b.x = 2
 IdentifyMyParts.x = 2
*/

/* El valor de x siempre está compartido con todas las
demás instancias, por lo cual siempre sale 2, porque ya
está definido.
 */