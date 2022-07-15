package com.example.shoppingcart.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shoppingcart.databinding.ItemShopBinding;
import com.example.shoppingcart.models.Product;

public class ShopListAdapter extends ListAdapter<Product, ShopListAdapter.ShopViewHolder> {
    ShopInterface shopInterface;

    public ShopListAdapter(ShopInterface shopInterface) {
        super(Product.itemCallback);
        this.shopInterface = shopInterface;
    }

    @NonNull
    @Override
    public ShopViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ItemShopBinding itemShopBinding = ItemShopBinding.inflate(layoutInflater, parent, false);
        itemShopBinding.setShopInterface(shopInterface);
        return new ShopViewHolder(itemShopBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ShopViewHolder holder, int position) {
        Product product = getItem(position);
        holder.itemShopBinding.setProduct(product);
        holder.itemShopBinding.executePendingBindings();
    }

    public class ShopViewHolder extends RecyclerView.ViewHolder {
        ItemShopBinding itemShopBinding;

        public ShopViewHolder(ItemShopBinding binding) {
            super(binding.getRoot());
            this.itemShopBinding = binding;

        }
    }

    public interface ShopInterface {
        void addItem(Product product);
        void onItemClick(Product product);
    }
}
