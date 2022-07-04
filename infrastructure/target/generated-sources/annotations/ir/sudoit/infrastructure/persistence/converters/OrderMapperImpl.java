package ir.sudoit.infrastructure.persistence.converters;

import ir.sudoit.core.order.OrderModel;
import ir.sudoit.infrastructure.persistence.entities.OrderEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-07-04T17:30:23+0430",
    comments = "version: 1.5.1.Final, compiler: javac, environment: Java 17.0.3.1 (Oracle Corporation)"
)
public class OrderMapperImpl implements OrderMapper {

    @Override
    public OrderModel toModel(OrderEntity order) {
        if ( order == null ) {
            return null;
        }

        OrderModel orderModel = new OrderModel();

        orderModel.setTitle( order.getTitle() );
        orderModel.setId( order.getId() );
        orderModel.setCreatedDate( order.getCreatedDate() );
        orderModel.setIsDeleted( order.getIsDeleted() );

        return orderModel;
    }

    @Override
    public OrderEntity toEntity(OrderModel model) {
        if ( model == null ) {
            return null;
        }

        OrderEntity orderEntity = new OrderEntity();

        orderEntity.setTitle( model.getTitle() );
        orderEntity.setCreatedDate( model.getCreatedDate() );
        orderEntity.setIsDeleted( model.getIsDeleted() );

        return orderEntity;
    }

    @Override
    public List<OrderModel> toModel(List<OrderEntity> orders) {
        if ( orders == null ) {
            return null;
        }

        List<OrderModel> list = new ArrayList<OrderModel>( orders.size() );
        for ( OrderEntity orderEntity : orders ) {
            list.add( toModel( orderEntity ) );
        }

        return list;
    }

    @Override
    public List<OrderEntity> toEntity(List<OrderModel> models) {
        if ( models == null ) {
            return null;
        }

        List<OrderEntity> list = new ArrayList<OrderEntity>( models.size() );
        for ( OrderModel orderModel : models ) {
            list.add( toEntity( orderModel ) );
        }

        return list;
    }
}
