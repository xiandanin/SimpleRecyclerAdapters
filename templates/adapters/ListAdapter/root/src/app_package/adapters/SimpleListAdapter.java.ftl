package ${packageName};

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ${superAdapterClassFqcn};

import java.util.List;
import ${applicationPackage}.R;

public class ${adapterClass} extends ${superAdapterClass}<${modelClass},${adapterClass}.ItemViewHolder> {

    public ${adapterClass}(List<${modelClass}> data) {
        super(data);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position, ${modelClass} item) {

    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
	<#if generateLayout>
        return new ItemViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.${layoutName}, parent, false));
	<#else>
        return null;
	</#if>
    }

    protected static class ItemViewHolder extends ${superAdapterClass}.ViewHolder{

        public ItemViewHolder(View itemView) {
            super(itemView);
        }
    }

}
