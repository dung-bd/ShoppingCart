package com.example.shoppingcart.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shoppingcart.databinding.CartItemBinding;
import com.example.shoppingcart.models.CartItem;

public class CartListAdapter extends ListAdapter<CartItem, CartListAdapter.CartViewHolder> {
    private CartInterface cartInterface;

    public CartListAdapter(CartInterface cartInterface) {
        super(CartItem.itemCallback);
        this.cartInterface = cartInterface;
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        CartItemBinding cartItemBinding = CartItemBinding.inflate(layoutInflater, parent, false);
        return new CartViewHolder(cartItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {
        final CartItem cartItem = getItem(position);
        holder.cartItemBinding.setCartItem(cartItem);
        holder.cartItemBinding.executePendingBindings();
    }

    public class CartViewHolder extends RecyclerView.ViewHolder {
        CartItemBinding cartItemBinding;

        public CartViewHolder(@NonNull CartItemBinding cartItemBinding) {
            super(cartItemBinding.getRoot());
            this.cartItemBinding = cartItemBinding;

            cartItemBinding.deleteProductButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    cartInterface.deleteItem(getItem(getAbsoluteAdapterPosition()));
                }
            });

            cartItemBinding.quantitySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    int quantity = position + 1;
                    if (quantity == getItem(getAbsoluteAdapterPosition()).getQuantity()) {
                        return;
                    }
                    cartInterface.changeQuantity(getItem(getAbsoluteAdapterPosition()), quantity);
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        }
    }

    public interface CartInterface {
        void deleteItem(CartItem cartItem);
        void changeQuantity(CartItem cartItem, int quantity);
    }
}
