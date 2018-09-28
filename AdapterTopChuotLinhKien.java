package quyen.nguyenvustore.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

import quyen.nguyenvustore.Model.ObjectClass.SanPham;
import quyen.nguyenvustore.R;

public class AdapterTopChuotLinhKien extends RecyclerView.Adapter<AdapterTopChuotLinhKien.ViewHolderTopChuot> {

    Context context;
    List<SanPham> sanPhamList;

    public AdapterTopChuotLinhKien(Context context, List<SanPham> sanPhamList) {
        this.context = context;
        this.sanPhamList = sanPhamList;
    }

    public class ViewHolderTopChuot extends RecyclerView.ViewHolder  {
        ImageView imHinhSanPham;
        TextView txtTenSP, txtGiaTien, txtGiamGia;

        public ViewHolderTopChuot(View itemView) {
            super(itemView);

            imHinhSanPham = (ImageView) itemView.findViewById(R.id.imTopChuotLinhKien);
            txtTenSP = (TextView) itemView.findViewById(R.id.txtTieuDeTopChuotLinhKien);
            txtGiaTien = (TextView) itemView.findViewById(R.id.txtGiaLinhKien);
            txtGiamGia = (TextView) itemView.findViewById(R.id.txtGiamGiaLinhKien);

        }
    }

    @Override
    public ViewHolderTopChuot onCreateViewHolder( ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.custom_layout_topchuotvabanphim, parent, false);

        ViewHolderTopChuot viewHolderTopChuot = new ViewHolderTopChuot(view);
        return viewHolderTopChuot;
    }

    @Override
    public void onBindViewHolder(ViewHolderTopChuot holder, int position) {
        SanPham sanPham = sanPhamList.get(position);
        Picasso.get().load(sanPham.getANHLON()).resize(140, 140).centerInside().into(holder.imHinhSanPham);
        holder.txtTenSP.setText(sanPham.getTENSP());

        NumberFormat numberFormat = new DecimalFormat("###,###");
        String gia = numberFormat.format(sanPham.getGIA()).toString();

        holder.txtGiaTien.setText(gia + " VNĐ");

    }

    @Override
    public int getItemCount() {
        return sanPhamList.size();
    }

}
