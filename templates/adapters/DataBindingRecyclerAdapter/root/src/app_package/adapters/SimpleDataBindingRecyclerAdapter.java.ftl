package ${packageName};

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import ${superAdapterClassFqcn};
import ${superHolderClassFqcn};

import java.util.List;
import ${applicationPackage}.databinding.${dataBindingClass};
import ${applicationPackage}.R;

public class ${adapterClass} extends ${superAdapterClass}<${modelClass},${dataBindingClass}> {

    public ${adapterClass}(List<${modelClass}> data) {
        super(data);
    }

	@Override
    protected int getItemLayoutId() {
	<#if generateLayout>
        return R.layout.${layoutName};
	<#else>
        return 0;
	</#if>
    }

    @Override
    public void onBindViewHolder(${superHolderClass}<${dataBindingClass}> holder, int position, String item) {

    }


}
