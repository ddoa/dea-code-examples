package nl.oose.dea.orderservice.withoutisp;

/**
 * Also possible to implement also ReadOnlyCartRepository and remove the extends relationship
 * between Repository and ReadOnlyRepository
 */
public interface CartRepository extends Repository<Cart> {
}
