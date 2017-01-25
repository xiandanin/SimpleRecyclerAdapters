package ${packageName};

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import ${superAdapterClassFqcn};

import java.util.List;

public class ${adapterClass} extends ${superAdapterClass}<${modelClass},${adapterClass}.Holder> {

    public ${adapterClass}(List<${modelClass}> data) {
        super(data);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position, ${modelClass} item) {

    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
	<#if generateLayout>
        return new Holder(LayoutInflater.from(parent.getContext()).inflate(R.layout.${layoutName}, parent, false));
	<#else>
        return null;
	</#if>
    }

    protected static class Holder extends RecyclerView.ViewHolder{

        public Holder(View itemView) {
            super(itemView);
        }
    }

}
