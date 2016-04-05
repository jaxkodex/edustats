package pe.org.edustats.service.converter;

import pe.com.horizonteti.util.commons.utils.AbstractDataConverter;
import pe.org.edustats.data.bean.CargoBean;
import pe.org.edustats.data.model.Cargo;

/**
 * Created by Jorge on 05/04/2016.
 */
public class CargoModelToBeanConverter extends AbstractDataConverter<Cargo, CargoBean> {
    @Override
    public CargoBean convert(Cargo cargo) {
        if (cargo == null) {
            return null;
        }

        CargoBean cargoBean = new CargoBean();
        cargoBean.setCoCargo(cargo.getCoCargo());
        cargoBean.setDeCargo(cargo.getDeCargo());
        return cargoBean;
    }
}
