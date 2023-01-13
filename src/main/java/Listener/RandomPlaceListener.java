package Listener;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RandomPlaceListener implements Listener {

    private boolean flag = false;

    /**
     * このシステムを有効化します
     */
    public void makeEnabled() { flag = true; }

    /**
     * このシステムを無効化します
     */
    public void makeDisabled() { flag = false; }

    @EventHandler
    private void Blockplace(BlockPlaceEvent e) {

        // 全部のマテリアルの中からブロックのみを取得し、シャッフルしたのちに一番目を取得する
        Material[] materials = Material.values();
        List<Material> blockMaterialList = Arrays.stream(materials).filter(F -> F.isBlock()).collect(Collectors.toList());
        Collections.shuffle(blockMaterialList);
        Material randomMaterial = blockMaterialList.get(0);

        Location block_loc = e.getBlock().getLocation();
        World world = Bukkit.getWorld("world"); //ここでワールドをゲット、違う世界(ネザー等)なら名前を変更する
        Block b = world.getBlockAt(block_loc); //ここで座標のブロックをゲット、置きたい座標に自分で変えてください。(x,y,z)
        b.setType(randomMaterial);
    }

}
