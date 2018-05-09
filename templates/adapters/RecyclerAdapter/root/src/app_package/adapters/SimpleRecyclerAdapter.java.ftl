package ${packageName};

import android.support.v7.widget.RecyclerView;
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
        return new ItemViewHolder(R.layout.${layoutName}, parent);
	<#else>
        return null;
	</#if>
    }

    protected static class ItemViewHolder extends BaseViewHolder{

        public ItemViewHolder(View itemView) {
            super(itemView);
        }


        public ItemViewHolder(@LayoutRes int layoutId, ViewGroup parent) {
            this(LayoutInflater.from(parent.getContext()).inflate(layoutId, parent, false));
        }
    }

}
